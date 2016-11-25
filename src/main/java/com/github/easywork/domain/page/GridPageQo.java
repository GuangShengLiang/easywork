package com.github.easywork.domain.page;

import lombok.Data;

/**
 * Created by user on 2016/11/9.
 */
@Data
public class GridPageQo {

    private Integer page = 1;

    private Integer rows = 20;

    private Integer sortId;

}
