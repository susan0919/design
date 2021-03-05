package com.example.design.compositeMethod;

import com.example.design.compositeMethod.model.EngineResult;
import com.example.design.compositeMethod.model.TreeRich;

import java.util.Map;

public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich,
                         final Map<String, String> decisionMatter);
}
