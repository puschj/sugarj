package org.sugarj.driver.caching;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.sugarj.driver.FileCommands;
import org.sugarj.driver.path.Path;

/**
 * The key of some SDF module as needed for caching.
 * 
 * Besides the actual SDF module, also the path for looking up
 * referenced modules is stored here. This way we do not need
 * to store a complete grammar, as represented by SDF definitions. 
 * 
 * @author Sebastian Erdweg <seba at informatik uni-marburg de>
 *
 */
public class ModuleKey implements Externalizable {

  private boolean checkGet;
  public Map<Path, Integer> imports;
  public String body;
  
  /**
   * For deserialization only.
   */
  public ModuleKey() {}
  
  public ModuleKey(Map<Path, Integer> imports, String body) {
    this.imports = imports;
    this.body = body;
  }
  
  public ModuleKey(Collection<Path> dependentFiles, IStrategoTerm module) throws IOException {
    this.imports = new HashMap<Path, Integer>();
    
    StringBuffer buf = new StringBuffer();
    module.writeAsString(buf, Integer.MAX_VALUE);
    this.body = buf.toString();
    
    for (Path file : dependentFiles)
      imports.put(file, FileCommands.fileHash(file));
  }
  
  public boolean equals(Object o) {
    if (!(o instanceof ModuleKey))
      return false;
    
    ModuleKey k = (ModuleKey) o;
    
    if (!body.equals(k.body))
      return false;
    
    return (checkGet ? imports.equals(k.imports) : imports.keySet().equals(k.imports.keySet()));
  }
  
  public int hashCode() {
    return imports.keySet().hashCode() + body.hashCode();
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    imports = new HashMap<Path, Integer>();
    int entries = in.readInt();
    for (int i = 0; i < entries; i++) {
      imports.put((Path) in.readObject(), in.readInt());
    }
    
    body = (String) in.readObject();
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(imports.size());
    for (Entry<Path, Integer> entry : imports.entrySet()) {
      out.writeObject(entry.getKey());
      out.writeInt(entry.getValue());
    }
    
    out.writeObject(body);
  }

  void doGet() {
    this.checkGet = true;
  }

  void doPut() {
    this.checkGet = false;
  }
  
}
