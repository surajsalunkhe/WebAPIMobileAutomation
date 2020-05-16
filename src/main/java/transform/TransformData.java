package transform;

import cucumber.api.Transformer;

public class TransformData extends Transformer<String> {

    @Override
    public String transform(String arg0){
        return arg0+"-suraj";
    }

}
