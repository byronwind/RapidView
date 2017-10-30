package com.tencent.rapidview.animation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Class AnimationChooser
 * @Desc Animation选择器
 *
 * @author arlozhang
 * @date 2016.08.16
 */
public class AnimationChooser {

    private static Map<String, IFunction> mClassMap = new ConcurrentHashMap<String, IFunction>();

    static{
        try{
            mClassMap.put("alphaanimation", RapidAlphaAnimationGeter.class.newInstance());
            mClassMap.put("animationset", RapidAnimationSetGeter.class.newInstance());
            mClassMap.put("rotateanimation", RapidRotateAnimationGeter.class.newInstance());
            mClassMap.put("scaleanimation", RapidScaleAnimationGeter.class.newInstance());
            mClassMap.put("translateanimation", RapidTranslateAnimationGeter.class.newInstance());
            mClassMap.put("animationlist", RapidFrameAnimationGeter.class.newInstance());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static AnimationObject get(RapidAnimationCenter center, String key){
        IFunction function;

        if( key == null ){
            return null;
        }

        function = mClassMap.get(key.toLowerCase());
        if( function == null ){
            return null;
        }

        return function.get(center);
    }

    public static boolean isExist(String key){
        if( key == null ){
            return false;
        }

        return mClassMap.get(key) != null;
    }

    private interface IFunction{
        AnimationObject get(RapidAnimationCenter center);
    }

    private static class RapidAlphaAnimationGeter implements IFunction{
        public RapidAlphaAnimationGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidAlphaAnimation(center);
        }
    }

    private static class RapidAnimationSetGeter implements IFunction{
        public RapidAnimationSetGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidAnimationSet(center);
        }
    }

    private static class RapidRotateAnimationGeter implements IFunction{
        public RapidRotateAnimationGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidRotateAnimation(center);
        }
    }

    private static class RapidScaleAnimationGeter implements IFunction{
        public RapidScaleAnimationGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidScaleAnimation(center);
        }
    }

    private static class RapidTranslateAnimationGeter implements IFunction{
        public RapidTranslateAnimationGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidTranslateAnimation(center);
        }
    }

    private static class RapidFrameAnimationGeter implements IFunction{
        public RapidFrameAnimationGeter(){}
        @Override
        public AnimationObject get(RapidAnimationCenter center){
            return new RapidFrameAnimation(center);
        }
    }
}
