package com.bdqn.entity;


import java.io.Serializable;

public class Grade implements Serializable {

  private int gradeId;
  private String gradeName;


  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }


  public String getGradeName() {
    return gradeName;
  }

  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }

}
