package com.nobug.experiment.tool.lamda;


/**
 * @author liyupeng01
 */
public interface LamdaDemo {

    LamdaDemo DEFAULT = (name) -> {
        try {
            switch (name) {
                case "SERVLET":
                    return "create SERVLET";
                case "REACTIVE":
                    return "create REACTIVE";
                default:
                    return "create default";
            }
        }
        catch (Exception ex) {
            throw new IllegalStateException("Unable create a default ApplicationContext instance, "
                    + "you may need a custom LamdaDemo", ex);
        }
    };

    String create(String name);


}
