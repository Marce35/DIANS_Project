package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    public List<Filter<T>> filters;

    public Pipe() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter<T> filter) {
        filters.add(filter);
    }

    public T runFilters(T data) {
        for (Filter<T> filter : filters) {
            data = filter.execute(data);
        }
        return data;
    }
}
