package sindre.ec.JPAinl.Data;

import org.springframework.data.repository.CrudRepository;
import sindre.ec.JPAinl.Entity.Ingredient;

import java.util.Optional;

public class IngredientRepo implements CrudRepository<Ingredient, Integer> {
    @Override
    public <S extends Ingredient> S save(S s) {
        return null;
    }

    @Override
    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Ingredient ingredient) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
