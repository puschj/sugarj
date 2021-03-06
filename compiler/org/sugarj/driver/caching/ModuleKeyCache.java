package org.sugarj.driver.caching;

import java.io.Serializable;


/**
 * @author Sebastian Erdweg <seba at informatik uni-marburg de>
 */
public class ModuleKeyCache<V extends Serializable> extends Cache<ModuleKey, V> {
  private static final long serialVersionUID = 7946929629107155889L;
  
  public void put(ModuleKey k, V v) {
    k.doPut();
    super.remove(k);
    super.put(k, v);
    k.doGet();
  }

  public V putGet(ModuleKey k, V v) {
    k.doPut();
    V old = super.get(k);
    super.remove(k);
    super.put(k, v);
    return old;
  }

  public V get(ModuleKey k) {
    k.doGet();
    return super.get(k);
  }
}
