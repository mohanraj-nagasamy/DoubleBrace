/**
 * Created by mohanraj.nagasamy on 8/11/13.
 */
public class OrderStatus {
    private String code;
    private String description;

    OrderStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public OrderStatus() {
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderStatus that = (OrderStatus) o;

        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
