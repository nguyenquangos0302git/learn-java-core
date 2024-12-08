package com.anything.reflection.reflection_with_constructor;

import com.anything.reflection.reflection_with_constructor.game.Game;
import com.anything.reflection.reflection_with_constructor.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Game game = createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    public static <T> T createObjectRecursively(Class<T> tClazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = getFirstConstructor(tClazz);

        List<Object> constructorArgs = new ArrayList<>();
        for (Class<?> argumentType : constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(argumentType);
            constructorArgs.add(argumentValue);
        }

        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArgs.toArray());
    }

    public static Constructor<?> getFirstConstructor(Class<?> clazz) throws IllegalAccessException {
        Constructor<?> [] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0){
            throw new IllegalAccessException(String.format("No constructor has been found for class: %s", clazz.getSimpleName()));
        }

        return constructors[0];
    }

}
