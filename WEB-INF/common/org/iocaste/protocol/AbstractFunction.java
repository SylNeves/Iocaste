package org.iocaste.protocol;

public abstract class AbstractFunction implements Function {

    @Override
    public abstract Object run(Message message);

}
