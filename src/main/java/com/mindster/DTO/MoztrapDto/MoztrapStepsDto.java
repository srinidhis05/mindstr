package com.mindster.DTO.MoztrapDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class MoztrapStepsDto {


    private String expected;

    private String instruction;

    public String getExpected ()
    {
        return expected;
    }

    public void setExpected (String expected)
    {
        this.expected = expected;
    }

    public String getInstruction ()
    {
        return instruction;
    }

    public void setInstruction (String instruction)
    {
        this.instruction = instruction;
    }

    @Override
    public String toString(){
        return "expected:"+expected+",instruction:"+instruction ;
    }



}
