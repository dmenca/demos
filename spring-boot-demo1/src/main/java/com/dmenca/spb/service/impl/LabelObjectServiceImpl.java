package com.dmenca.spb.service.impl;

import com.dmenca.spb.dto.LabelObjectDTO;
import com.dmenca.spb.manager.LabelObjectManager;
import com.dmenca.spb.model.LabelObject;
import com.dmenca.spb.service.LabelObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelObjectServiceImpl implements LabelObjectService {

    @Autowired
    private LabelObjectManager labelObjectManager;

    @Override
    public List<LabelObjectDTO> getLabelObjectsByObjectId(String objectId) {
        List<LabelObject> labelsByObjectIds = labelObjectManager.getLabelsByObjectIds(objectId);
        return labelsByObjectIds.stream().map(labelObject -> {
            LabelObjectDTO labelObjectDTO = new LabelObjectDTO();
            labelObjectDTO.setObjectId(labelObject.getObjectId());
            labelObjectDTO.setName(labelObject.getName());
            return labelObjectDTO;
        }).collect(Collectors.toList());
    }
}
