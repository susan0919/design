package com.example.design.compositeMethod;

import com.example.design.compositeMethod.model.TreeNodeLink;

import java.util.List;
import java.util.Map;

public interface LogicalFilter {
    Long filter(String materValue, List<TreeNodeLink> links);

    String matterValue(Long treeId, String userId, Map<String, String> matter);
}
