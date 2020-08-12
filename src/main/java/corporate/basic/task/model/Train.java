package corporate.basic.task.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Train
{
    private final List<Carriage> carriages;

    public Train()
    {
        this.carriages = new ArrayList<>();
    }

    public List<Carriage> getCarriages()
    {
        return carriages;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
