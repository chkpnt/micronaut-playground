package micronaut.playground;

import com.google.common.collect.ImmutableMap;
import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.qualifiers.Qualifiers;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class ExampleConfigurationTest {

    @Test
    void test() {
        Map<String, Object> properties = ImmutableMap.<String, Object>builder()
                .put("example.some-kebab-property", "yufka")
                .put("example.nested[0].simple", "simple-0")
                .put("example.nested[0].some-other-kebab", "yufka-0")
                .put("example.nested[0].foobar", "foobar-0")
                .put("example.nested[1].simple", "simple-1")
                .put("example.nested[1].someOtherKebab", "yufka-1")
                .put("example.nested[1].foobar", "foobar-1")
                .put("example.nested[2].simple", "simple-2")
                .put("example.nested[2].someotherkebab", "yufka-2")
                .put("example.nested[2].foobar", "foobar-2")
                .build();
        ApplicationContext applicationContext = ApplicationContext.run(ApplicationContext.class, properties);

        ExampleConfiguration config = applicationContext.getBean(
                ExampleConfiguration.class);

        assertThat(config.getSomeKebabProperty(), is("yufka"));
        assertThat(config.getNested(), hasSize(3));
        assertThat(config.getNested().get(0).getSimple(), is("simple-0"));
        assertThat(config.getNested().get(0).getFoobar(), is("foobar-0"));
        assertThat(config.getNested().get(0).getSomeOtherKebab(), is("yufka-0"));
    }
}