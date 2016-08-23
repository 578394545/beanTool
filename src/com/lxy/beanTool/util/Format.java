/*    */ package com.lxy.beanTool.util;
/*    */ 
/*    */ public class Format
/*    */ {
/*    */   public static final String SPACE = " ";
/*    */   public static final String NEWLINE = "\n";
/*    */   public static final String TAB = "\t";
/*    */   public static final String PACKAGE = "package";
/*    */   public static final String PUBLIC = "public";
/*    */   public static final String CLASS = "class";
/*    */   public static final String PRIVATE = "private";
/*    */   public static final String SEMICOLON = ";";
/*    */   public static final String DIAGONAL = "/";
/*    */   public static final String DOUBLEDIAGONAL = "//";
/*    */   public static final String STAR = "*";
/*    */   public static final String DOUBLESTAR = "**";
/*    */   public static final String BR = "<br />";
/*    */   public static final String SD = "设定";
/*    */   public static final String QD = "取得";
/*    */   public static final String AT = "@";
/*    */   public static final String PARAM = "param";
/*    */   public static final String GROUP = "\t *";
/*    */   public static final String VOID = "void";
/*    */   public static final String SET = "set";
/*    */   public static final String GET = "get";
/*    */   public static final String BRACKET_LEFT = "(";
/*    */   public static final String BRACKET_RIGHT = ")";
/*    */   public static final String BRACES_LEFT = "{";
/*    */   public static final String BRACES_RIGHT = "}";
/*    */   public static final String POINT = ".";
/*    */   public static final String EQUAL = "=";
/*    */   public static final String THIS = "this.";
/*    */   public static final String RETURN = "return";
/*    */ 
/*    */   public static String toUpperCase(String pName)
/*    */   {
/* 60 */     pName = pName.trim();
/* 61 */     return pName.substring(0, 1).toUpperCase() + pName.substring(1);
/*    */   }
/*    */ }

/* Location:           C:\Users\刘雪毅\Desktop\beanTool.jar
 * Qualified Name:     com.lxy.beanTool.util.Format
 * JD-Core Version:    0.6.2
 */