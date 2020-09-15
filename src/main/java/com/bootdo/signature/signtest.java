package com.bootdo.signature;

import com.bootdo.common.seal.SealUtil;
import com.bootdo.common.seal.configuration.SealCircle;
import com.bootdo.common.seal.configuration.SealConfiguration;
import com.bootdo.common.seal.configuration.SealFont;

import java.awt.*;
import java.io.IOException;

public class signtest {
    public static void main(String[] args) throws Exception {
        /**
         * 印章配置文件
         */
        SealConfiguration configuration = new SealConfiguration();

        /**
         * 主文字
         */
        SealFont mainFont = new SealFont();
        mainFont.setBold(false);
        mainFont.setFontFamily("宋体");
        mainFont.setMarginSize(5);
        mainFont.setFontText("HUNAN QUN LONG LAW OFFICE");
        mainFont.setFontSize(29);
        mainFont.setFontSpace(19.0);

        /**
         * 副文字
         */
        SealFont viceFont = new SealFont();
        viceFont.setBold(true);
        viceFont.setFontFamily("宋体");
        viceFont.setMarginSize(-2);
        viceFont.setFontText("4301030153209");
        viceFont.setFontSize(18);
        viceFont.setFontSpace(12.0);


        /**
         * 中心文字
         */
        SealFont centerFont = new SealFont();
        centerFont.setBold(true);
        centerFont.setFontFamily("宋体");
        centerFont.setFontText("★");
        centerFont.setFontSize(100);

        /**
         * 抬头文字
         */
        SealFont titleFont = new SealFont();
        titleFont.setBold(true);
        titleFont.setFontFamily("宋体");
        titleFont.setMarginSize(45);
        titleFont.setFontSize(30);
        titleFont.setFontSpace(30.0);
        titleFont.setFontText("湖南群龙律师事务所");


        /**
         * 添加主文字
         */
        configuration.setMainFont(mainFont);
        /**
         * 添加副文字
         */
        configuration.setViceFont(viceFont);
        /**
         * 添加中心文字
         */
        configuration.setCenterFont(centerFont);
        /**
         * 添加抬头文字
         */
        configuration.setTitleFont(titleFont);

        /**
         * 图片大小
         */
        configuration.setImageSize(300);
        /**
         * 背景颜色
         */
        configuration.setBackgroudColor(Color.RED);
        /**
         * 边线粗细、半径
         */
        //configuration.setBorderCircle(new SealCircle(3, 140, 140));
        configuration.setBorderCircle(new SealCircle(3, 140, 140));
        /**
         * 内边线粗细、半径
         */
        //configuration.setBorderInnerCircle(new SealCircle(1, 135, 135));
        configuration.setBorderInnerCircle(new SealCircle(1, 135, 135));

        /**
         * 中心线粗线、半径
         */
        configuration.setCentreCircle(new SealCircle(1,100,100));
        /**
         * 内环线粗细、半径
         */
        //configuration.setInnerCircle(new SealCircle(2, 105, 105));
        configuration.setInnerCircle(new SealCircle(1, 55, 55));

        //1.生成公章  E:\千蓝软件\群龙律师事务所\微信图片_20200914141724.jpg
        try {  // E:\千蓝软件\签章DEMO\SealUtil-master\img
            SealUtil.buildAndStoreSeal(configuration, "E:\\千蓝软件\\GenerateSeal\\公章666.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.生成私章
        SealFont font = new SealFont();
        font.setFontSize(120).setBold(true).setFontText("刘鹏");
        SealUtil.buildAndStorePersonSeal(300, 16, font, "印", "E:\\千蓝软件\\GenerateSeal\\私章6666.png");
    }

}
