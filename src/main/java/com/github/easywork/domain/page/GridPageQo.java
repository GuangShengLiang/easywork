package com.github.easywork.domain.page;

import lombok.Data;

@Data
public class GridPageQo {

    private Integer page = 1;

    private Integer rows = 20;

    private Integer sortId;

}
