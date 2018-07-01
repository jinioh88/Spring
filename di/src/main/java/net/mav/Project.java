package net.mav;

import java.util.List;

public class Project {
    private List<String> srcDirs;
    private String binDir;
    private BuildRunner buildRunner;

    public void build(){
        buildRunner.build(srcDirs,binDir);
    }

    public List<String> getSrcDirs() {
        return srcDirs;
    }

    public void setSrcDirs(List<String> srcDirs) {
        this.srcDirs = srcDirs;
    }

    public String getBinDir() {
        return binDir;
    }

    public void setBinDir(String binDir) {
        this.binDir = binDir;
    }

    public BuildRunner getBuildRunner() {
        return buildRunner;
    }

    public void setBuildRunner(BuildRunner buildRunner) {
        this.buildRunner = buildRunner;
    }
}
