package com.dmenca.spb.service;

import com.dmenca.spb.dto.LabelObjectDTO;

import java.util.List;

public interface LabelObjectService {

    List<LabelObjectDTO> getLabelObjectsByObjectId(String objectId);
}
