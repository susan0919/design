package com.example.design.compositeMethod;

import com.example.design.compositeMethod.model.EngineResult;
import com.example.design.compositeMethod.model.TreeNode;
import com.example.design.compositeMethod.model.TreeRich;
import com.example.design.compositeMethod.model.TreeRoot;

import java.util.Map;

public abstract class EngineBase extends EngineConfig implements IEngine {


    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String,
            String> decisionMatter);

//    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId,
//                                           Map<String, String> decisionMatter) {
//        TreeRoot
//
//    }
}
