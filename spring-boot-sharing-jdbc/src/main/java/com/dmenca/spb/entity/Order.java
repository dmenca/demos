package com.dmenca.spb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order")
public class Order {
    @TableId(
            value = "order_id",
            type = IdType.ASSIGN_ID
    )
    private Long orderId;

    private String orderNo;

    private String createName;

    private Float price;

}
