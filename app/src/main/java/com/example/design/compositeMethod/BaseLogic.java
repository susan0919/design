package com.example.design.compositeMethod;

import com.example.design.compositeMethod.model.TreeNodeLink;

import java.util.List;
import java.util.Map;

public abstract class BaseLogic implements LogicalFilter {
    @Override
    public Long filter(String materValue, List<TreeNodeLink> links) {
        for (TreeNodeLink link : links) {
            if (decisionLogic(materValue, link)) {
                return link.getNodeIdTo();
            }
        }
        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> matter);

    private boolean decisionLogic(String materValue, TreeNodeLink treeNodeLink) {
        switch (treeNodeLink.getRuleLimitType()) {
            case 1:
                return materValue.equals(treeNodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(materValue) > Double.parseDouble(treeNodeLink.ruleLimitValue);
            case 3:
                return Double.parseDouble(materValue) < Double.parseDouble(treeNodeLink.getRuleLimitValue());
            default:
                return false;
        }

    }
}
