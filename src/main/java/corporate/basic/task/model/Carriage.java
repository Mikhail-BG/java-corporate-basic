package corporate.basic.task.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Carriage
{
    private final List<Cargo> cargos;
    private int capacity;

    public Carriage(int capacity)
    {
        this.capacity = capacity;
        this.cargos = new ArrayList<>();
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public List<Cargo> getCargos()
    {
        return cargos;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
