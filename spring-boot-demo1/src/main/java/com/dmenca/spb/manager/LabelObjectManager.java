package com.dmenca.spb.manager;

import com.dmenca.spb.dao.LabelDao;
import com.dmenca.spb.dto.AddLabelObjectRequest;
import com.dmenca.spb.model.LabelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class LabelObjectManager {

    @Autowired
    private LabelDao labelDao;

    public void save(AddLabelObjectRequest addLabelObjectRequest){
        LabelObject labelObject = new LabelObject();
        labelObject.setObjectId(addLabelObjectRequest.getObjectId());
        labelObject.setName(addLabelObjectRequest.getName());
        labelObject.setId(Math.abs(new Random().nextLong()));
        labelDao.save(labelObject);
    }

    public List<LabelObject> getLabelsByObjectIds(String objectId){
        return labelDao.getLabelsByObjectId(objectId);
    }

}
