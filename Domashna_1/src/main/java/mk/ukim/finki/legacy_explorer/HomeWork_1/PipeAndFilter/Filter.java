package mk.ukim.finki.legacy_explorer.HomeWork_1.PipeAndFilter;

public interface Filter<T> {
    T execute(T data);
}
