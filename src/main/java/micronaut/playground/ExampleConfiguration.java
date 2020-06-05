package micronaut.playground;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("example")
public class ExampleConfiguration {

    private String someKebabProperty;
    private List<NestedConfiguration> nested;

    public String getSomeKebabProperty() {
        return someKebabProperty;
    }

    public void setSomeKebabProperty(String someKebabProperty) {
        this.someKebabProperty = someKebabProperty;
    }

    public List<NestedConfiguration> getNested() {
        return nested;
    }

    public void setNested(List<NestedConfiguration> nested) {
        this.nested = nested;
    }

    public static final class NestedConfiguration {

        private String simple;

        private String someOtherKebab;

        private String foobar;

        public String getSimple() {
            return simple;
        }

        public void setSimple(String simple) {
            this.simple = simple;
        }

        public String getSomeOtherKebab() {
            return someOtherKebab;
        }

        public void setSomeOtherKebab(String someOtherKebab) {
            this.someOtherKebab = someOtherKebab;
        }

        public String getFoobar() {
            return foobar;
        }

        public void setFoobar(String foobar) {
            this.foobar = foobar;
        }
    }
}
