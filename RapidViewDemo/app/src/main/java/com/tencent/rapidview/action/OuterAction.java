package com.tencent.rapidview.action;

import com.tencent.rapidview.data.Var;
import com.tencent.rapidview.deobfuscated.IRapidActionListener;

import org.w3c.dom.Element;

import java.util.Map;

/**
 * @Class OuterAction
 * @Desc 界面索取方提供的actionList，索取方应当实现OuterActionListener接口，并根据参数执行相应动作。
 *
 * @author arlozhang
 * @date 2016.03.23
 */
public class OuterAction extends ActionObject {

    public OuterAction(Element element, Map<String, String> mapEnv){
        super(element, mapEnv);
    }


    @Override
    public boolean run(){
        Var key = mMapAttribute.get("key");
        Var value = mMapAttribute.get("value");
        IRapidActionListener listener = null;

        if( mRapidView == null ){
            return false;
        }

        listener = mRapidView.getParser().getActionListener();

        if(  listener == null ){
            return false;
        }

        if( key == null ){
            key = new Var("");
        }

        if( value == null ){
            value = new Var("");
        }

        listener.notify(key.getString(), value.getString());

        return true;
    }
}
