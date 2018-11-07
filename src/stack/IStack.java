package stack;

public interface IStack<E> {
    /**
     * 进栈
     * e!=null
     */
    void push(E e);

    /**
     * 出栈
     * @return 出栈对象 没有返回null
     */
    E pop();

    /**
     * 查看堆栈顶部的对象，但不从堆栈中移除它
     * @return 栈顶对象 没有返回null
     */
    E peek();

    /**
     * 检验是否为空栈
     * @return 如果是空栈返回true 否则返回false
     */
    boolean isEmpty();
}
