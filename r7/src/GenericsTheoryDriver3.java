import java.lang.reflect.Array;
import java.util.Arrays;

class Tensor<T extends Number> {

    private T[] data;
    private int[] shape;

    // For example, a tensor can be
    private int[][][][][][] someArray = new int[10][12][14][67][2][3]; // with shape (10, 12, 14, 67, 2, 3)

    public Tensor(Class<T> typeClass, int... shape) {
        this.shape = shape;
        int size = 1;
        for (int dim : shape) {
            size *= dim;
        }
        // Create a generic array to hold the tensor elements
        this.data = (T[]) Array.newInstance(typeClass, size);
    }

    // Set value at a specific index
    public void set(T value, int... indices) {
        int flatIndex = getFlatIndex(indices);
        data[flatIndex] = value;
    }

    // Get value at a specific index
    public T get(int... indices) {
        int flatIndex = getFlatIndex(indices);
        return data[flatIndex];
    }

    public T[] getData() {
        return data;
    }

    public void setData(int index, T value) {
        this.data[index] = value;
    }

    // Get the shape of the tensor
    public int[] getShape() {
        return shape;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(Tensor) shape ").append(Arrays.toString(shape)).append("\n");
        if (shape.length == 0) {
            if (data[0] != null) {
                sb.append(data[0].toString());
            } else {
                sb.append("null");
            }
        } else {
//            return Arrays.toString(data);
            toStringRecursive(sb, 0, 0);
        }
        return sb.append("\n").toString();
    }

    // Recursively generate the string for each nested level
    private void toStringRecursive(StringBuilder sb, int depth, int start) {
        if (depth == shape.length - 1) {
            // Print the final dimension as a row
            sb.append("[");
            for (int i = 0; i < shape[depth]; i++) {
                sb.append(data[start + i]);
                if (i < shape[depth] - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        } else {
            // Print nested levels with appropriate structure
            sb.append("[");
            for (int i = 0; i < shape[depth]; i++) {
                toStringRecursive(sb, depth + 1, start + i * getStride(depth + 1));
                if (i < shape[depth] - 1) {
                    sb.append(",\n");
                }
            }
            sb.append("]");
        }
    }

    // Calculate the stride at a given depth (the number of elements per slice of that dimension)
    private int getStride(int depth) {
        int stride = 1;
        for (int i = depth; i < shape.length; i++) {
            stride *= shape[i];
        }
        return stride;
    }

    // Method to compute the flat index from multi-dimensional indices
    private int getFlatIndex(int... indices) {
        if (indices.length != shape.length) {
            throw new IllegalArgumentException("Number of indices must match tensor dimensions");
        }
        int flatIndex = 0;
        int stride = 1;
        for (int i = shape.length - 1; i >= 0; i--) {
            flatIndex += indices[i] * stride;
            stride *= shape[i];
        }
        return flatIndex;
    }
}

class Operator {
    public static <T extends Number> Tensor<T>
        add(Tensor<T> a, Tensor<T> b) {

        // Check if shapes match
        if (!Arrays.equals(a.getShape(), b.getShape())) {
            throw new IllegalArgumentException("Tensors must have the same shape to be added");
        }

        // Create a new tensor to hold the result
        Tensor<T> result = new Tensor<>((Class<T>) a.getData().getClass().getComponentType(), a.getShape());

        // Perform element-wise addition
        for (int i = 0; i < a.getData().length; i++) {
            T value1 = a.getData()[i];
            T value2 = b.getData()[i];
            // intuition
            //T newValue = (T) (Long) ((Long) value1 + (Long) value2);
            T newValue;
            if (value1 instanceof Long || value2 instanceof Long) {
                newValue = (T) (Long) ((Long) value1 + (Long) value2);
            } else if (value1 instanceof Float || value2 instanceof Float) {
                newValue = (T) (Float) ((Float) value1 + (Float) value2);
            } else if (value1 instanceof Double || value2 instanceof Double) {
                newValue = (T) (Double) ((Double) value1 + (Double) value2);
            } else if (value1 instanceof Integer || value2 instanceof Integer) {
                newValue = (T) (Integer) ((Integer) value1 + (Integer) value2);
            } else {
                throw new UnsupportedOperationException("Unsupported type for addition");
            }
            result.setData(i, newValue);
        }
        return result;
    }
}


public class GenericsTheoryDriver3 {
    public static void main(String[] args) {

        Tensor<Integer> x1 = new Tensor<>(Integer.class); // shape () => a single integer
        System.out.println(x1);

        x1.set(12);
        System.out.println(x1);

        Tensor<Double> x2 = new Tensor<>(Double.class, 2, 3); // shape (2, 3) => a matrix with 2 rows and 3 columns
        System.out.println(x2);

        x2.set(16d, 0, 0);
        x2.set(14d, 0, 1);
        x2.set(12d, 0, 2);
        x2.set(8d, 1, 0);
        x2.set(6d, 1, 1);
        x2.set(4d, 1, 2);
        System.out.println(x2);

        Tensor<Double> x3 = new Tensor<>(Double.class, 2, 3); // shape (2, 3) => a matrix with 2 rows and 3 columns
        System.out.println(x3);

        x3.set(20d, 0, 0);
        x3.set(1d, 0, 1);
        x3.set(13d, 0, 2);
        x3.set(9d, 1, 0);
        x3.set(5d, 1, 1);
        x3.set(2d, 1, 2);
        System.out.println(x3);

        Tensor<Double> x4 = Operator.add(x2, x3);
        System.out.println(x4);

    }
}
