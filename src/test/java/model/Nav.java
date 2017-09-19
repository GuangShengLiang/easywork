package model;

import lombok.Data;

@Data
public class Nav {

    private Da data;

    @Data
    public static class Da{
        private int video;
    }
}
