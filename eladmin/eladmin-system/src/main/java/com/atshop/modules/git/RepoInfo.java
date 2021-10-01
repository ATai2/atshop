package com.atshop.modules.git;

import lombok.Data;

@Data
public class RepoInfo {
    private String path;
    private String branch;
    private String revision;
}
