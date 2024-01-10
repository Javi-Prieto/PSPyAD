package org.example;



public  class  Contains<T> {
    private T[] items;

    public Contains(T[] items){
        this.items = items;
    }

    public boolean contains(T value, boolean identity){
        T[] items = this.items;

        int i = items.length -1;
        if(identity  || value == null){
            while(i >= 0)
                if (items[i--] == value) return true;
        }else{
            while (i >= 0 )
                if (value.equals(items[i--])) return true;
        }
        return false;
    }

}
