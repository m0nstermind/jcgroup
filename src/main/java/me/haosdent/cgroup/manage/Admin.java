package me.haosdent.cgroup.manage;

import me.haosdent.cgroup.util.Shell;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Admin {

  public static final String PATH_ROOT = ".";
  private Shell shell;
  private String name;
  private int subsystems;
  private String password;
  private Group rootGroup;
  private List<Group> groupList = new LinkedList<Group>();

  public Admin(String name, String password, int subsystems) throws IOException {
    init(name, password, subsystems);
  }

  private void init(String name, String password, int subsystems) throws IOException {
    this.name = name;
    this.password = password;
    this.subsystems = subsystems;
    this.shell = new Shell(this);
    shell.mount(name, subsystems);
    this.rootGroup = new Group(this, PATH_ROOT, subsystems, true);
  }

  public void umount() throws IOException {
    Object[] groups = groupList.toArray();
    for (Object group : groups) {
      ((Group) group).delete();
    }
    shell.umount(name);
  }

  public Shell getShell() {
    return shell;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public Group getRootGroup() {
    return rootGroup;
  }

  public List<Group> getGroupList() {
    return groupList;
  }

  public Group createGroup(String name, int subsystems) throws IOException {
    Group group = new Group(this, name, subsystems);
    return group;
  }
}
