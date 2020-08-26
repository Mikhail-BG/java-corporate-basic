package corporate.basic.task.model;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BaseModel {
    @Override
    public String toString() {
        ToStringStyle style = new CustomStyle();
        return new ReflectionToStringBuilder(this, style).toString();
    }

    private static class CustomStyle extends RecursiveToStringStyle{
        public CustomStyle() {
            super();
            setUseClassName(false);
            setUseIdentityHashCode(false);

            setContentStart("");
            setContentEnd("\n");

            setFieldSeparator(", ");
            setFieldNameValueSeparator(" = ");

            setArraySeparator("");
            setArrayStart("[\n");
            setArrayEnd("]");
        }
    }
}
