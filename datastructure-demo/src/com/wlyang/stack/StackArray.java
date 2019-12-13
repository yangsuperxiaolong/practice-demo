package com.wlyang.stack;

/**
 * @Description: 使用数组实现栈
 * @author: wlyang
 * @since: 2019-12-13
 */
public class StackArray<T> {
    private int maxSize;
    private Object[] stack;
    private int size;
    private int top;
    private int buttom;

    //构造函数
    public StackArray(int maxSize) {
        this.maxSize =maxSize;
        stack = new Object[maxSize];
        size = 0;
        top = buttom = -1;
    }

    /**
     * 判断栈是否已满
     *
     * @return
     */
    public Boolean isFull() {
        if (top == maxSize - 1) {
            return true;
        }
        return false;
    }


    /**
     * 判断栈是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * 求栈的元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("当前栈为空");
            return null;
        }
        T result = (T) stack[top];
        top--;
        size--;
        return result;
    }

    public void push(T t) {
        if (isFull()) {
            System.out.println("当前栈已满");
            return;
        }
        size++;
        stack[++top] = t;
    }


}
