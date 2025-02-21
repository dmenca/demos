package com.dmenca.spb.dao;

import com.dmenca.spb.model.Address;
import com.dmenca.spb.model.LabelObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LabelDao {

    private static final Map<String, List<LabelObject>> labelObjectMap = new HashMap<>();

    public List<LabelObject> getLabelsByObjectId(String objectId){
        return labelObjectMap.get(objectId);
    }

    public void save(LabelObject labelObject){
        List<LabelObject> labelObjects = labelObjectMap.getOrDefault(labelObject.getObjectId(), new ArrayList<>());
        labelObjects.add(labelObject);
        labelObjectMap.put(labelObject.getObjectId(),labelObjects);
    }


}
