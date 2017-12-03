package com.oakland.shiftreport.shiftreport.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class ShiftReport {
    @Id
    @NotNull
    private int id;
    @NotNull
    private Date date;
    @NotNull
    private Shift shift;
    @NotNull
    private String shiftManager;
    @NotNull
    private Integer unitsMade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getShiftManager() {
        return shiftManager;
    }

    public void setShiftManager(String shiftManager) {
        this.shiftManager = shiftManager;
    }

    public int getUnitsMade() {
        return unitsMade;
    }

    public void setUnitsMade(int unitsMade) {
        this.unitsMade = unitsMade;
    }
}
