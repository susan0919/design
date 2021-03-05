package com.example.design.compositeMethod;

import java.util.Map;

public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> matter) {
        return matter.get("age");
    }
}
