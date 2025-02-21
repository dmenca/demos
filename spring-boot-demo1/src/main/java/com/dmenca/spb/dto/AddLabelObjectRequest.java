package com.dmenca.spb.dto;

import lombok.Data;

@Data
public class AddLabelObjectRequest {
    private String objectId;
    private String name;
}
