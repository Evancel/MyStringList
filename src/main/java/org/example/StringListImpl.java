package org.example;

import org.example.exceptions.ElementNotFoundException;
import org.example.exceptions.NullElementException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] arrayStrings;
    private int initialSize;

    private String[] extendedArray;

    public StringListImpl(int MySize) {
        this.initialSize = MySize;
        arrayStrings = new String[initialSize];
    }

    public StringListImpl(String[] ar){
        this.arrayStrings = ar;
    }

    public String add(String item) {
        boolean isNewElementAdded = false;

        if (item == null || item.isBlank()) {
            throw new NullElementException();
        }

        for (int i = 0; i < arrayStrings.length; i++) {
            if (arrayStrings[i] == null) {
                arrayStrings[i] = item;
                isNewElementAdded = true;
                break;
            }
        }

        if (!isNewElementAdded) {
            //расширяем текущий массив
            extendedArray = Arrays.copyOf(arrayStrings, arrayStrings.length + 10);
            extendedArray[arrayStrings.length] = item;
            arrayStrings = extendedArray;
            isNewElementAdded = true;
        }

        return item;
    }

    public String add(int index, String item) {

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (item == null || item.isBlank()) {
            throw new NullElementException();
        }

        String[] copyOfArray = new String[arrayStrings.length + 1];
        String[] temp = Arrays.copyOf(arrayStrings, arrayStrings.length);

        // !THE SEQUENCE OF BLOCK IF IS ESSENTIAL
        if (index >= arrayStrings.length) {
            add(item);
        } else if (arrayStrings[index] != null) {
            arrayStrings[index] = item;
            System.arraycopy(arrayStrings, 0, copyOfArray, 0, index + 1);
            System.arraycopy(temp, index, copyOfArray, index + 1, temp.length - (index));
            arrayStrings = copyOfArray;
        } else if (index == 0) {
            add(item);
        } else if (arrayStrings[index - 1] == null) {
            add(index - 1, item);
        } else {
            arrayStrings[index] = item;
        }

        return item;
    }

    public String set(int index, String item) {

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (item == null || item.isBlank()) {
            throw new NullElementException();
        }

        if (index < arrayStrings.length) {
            //проверяем, что есть свободные ячейки
            if (index <= this.size()) {
                //если пытаемся вставить значение в уже заполненную или следующую ячейку
                if (index == 0 || arrayStrings[index - 1] != null) {
                    arrayStrings[index] = item;
                } else {
                    set(index - 1, item);
                }

            } else {
                //если пытаемся вставить значение в середину пустых ячеек
                //изменяем индекс на следующий после уже существующего элемента в массиве
                set(this.size(), item);
            }

        } else {
            //расширяем диапазон и вставляем в следующую свободную ячейку
            add(item);
        }

        return item;
    }

    public String remove(String item) {

        if (item == null || item.isBlank()) {
            throw new NullElementException();
        } else if (!contains(item)) {
            throw new ElementNotFoundException();
        }

        for (int i = 0; i < this.size(); i++) {
            if (arrayStrings[i].equals(item)) {
                arrayStrings[i] = null;
                String[] newArray = Arrays.copyOf(arrayStrings, arrayStrings.length);
                System.arraycopy(arrayStrings, i + 1, newArray, i, arrayStrings.length - (i + 1));
                arrayStrings = newArray;
                break;
            }
        }

        return item;
    }

    public String remove(int index) {


        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        String temp = arrayStrings[index];
        arrayStrings[index] = null;
        String[] newArray = Arrays.copyOf(arrayStrings, arrayStrings.length);
        System.arraycopy(arrayStrings, index + 1, newArray, index, arrayStrings.length - (index + 1));
        arrayStrings = newArray;

        return temp;
    }

    public boolean contains(String item) {
        boolean isElementFounded = false;
        for (int i = 0; i < this.size(); i++) {
            if (arrayStrings[i].equals(item)) {
                isElementFounded = true;
                break;
            }
        }
        return isElementFounded;
    }

    public int indexOf(String item) {
        int index = -1;

        if (item == null) {
            throw new NullElementException();
        }

        for (int i = 0; i < this.size(); i++) {
            if (arrayStrings[i].equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int lastIndexOf(String item) {
        int index = -1;

        if (item == null) {
            throw new NullElementException();
        }

        for (int i = this.size() - 1; i >= 0; i--) {
            if (arrayStrings[i].equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        return arrayStrings[index];
    }

    public boolean equals(StringList otherList) {
        if(otherList==null){
            throw new NullElementException();
        }

        boolean isEquals = false;

        if (this.size() == otherList.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (!arrayStrings[i].equals(otherList.get(i))) {
                    isEquals = false;
                    break;
                }
                //если элементы равны переключаем счетчик на true,
                //если доходим до конца цикла for и значение остается true,
                //значит все элементы равны
                //иначе в цикле переключаем счетчик на false и выходим из цикла
                isEquals = true;
            }
        }

        return isEquals;
    }

    public int size() {
        int actualSize = 0;
        for (int i = 0; i < arrayStrings.length; i++) {
            if (arrayStrings[i] != null) {
                actualSize++;
            }
        }
        return actualSize;
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public void clear() {
        while (this.size() > 0) {
            remove(0);
        }
    }

    public String[] toArray() {
        String[] CopyOfArray = new String[this.size()];
        for (int i = 0; i < CopyOfArray.length; i++) {
            CopyOfArray[i] = arrayStrings[i];
        }
        return CopyOfArray;
    }

    @Override
    public String toString() {
        return "StringListImpl{" + "arrayStrings=" + Arrays.toString(arrayStrings) + ", size=" + this.size() +
                //  ", extendedArray=" + Arrays.toString(extendedArray) +
                '}';
    }
}
