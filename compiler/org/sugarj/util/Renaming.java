package org.sugarj.util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.sugarj.driver.Environment;
import org.sugarj.driver.FileCommands;
import org.sugarj.driver.path.RelativePath;

/**
 * @author seba
 */
public class Renaming implements Serializable {
  private static final long serialVersionUID = -3707638775569347652L;

  public List<String> pkgs;
  public String from;
  public String to;
  
  public Renaming(List<String> pkgs, String from, String to) {
    this.pkgs = pkgs;
    this.from = from;
    this.to = to;
  }

  public Renaming(RelativePath fromPath, RelativePath toPath) {
    this.from = FileCommands.fileName(fromPath);
    this.to = FileCommands.fileName(toPath);
    this.pkgs = new LinkedList<String>();
    for (String pkg : fromPath.getRelativePath().split(Environment.sep))
      this.pkgs.add(pkg);
    this.pkgs.remove(this.pkgs.size() - 1);
  }
}
