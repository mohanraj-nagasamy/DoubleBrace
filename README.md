# Blocks in Java Lang

We all love blocks in Ruby.  Wouldn’t that be great if Java Lang had support for blocks? Well, Java Lang will support blocks/lambdas in jdk8.  Until you get a chance to work with jdk8 for real blocks/lambdas, there is an old trick we can apply while creating/initializing an object. That is called a less known “Double Brace Initialization” java idiom.  This just works for creating/initializing an object. You can’t apply in other places like you would in Ruby.

This trick works in all the version of java as well.
Let’s say you have the following class from external library and want to create a list of valid order statuses:
Link code
First you would create something like this:

```final static Set<OrderStatus> VALID_ORDER_STATUSES = new HashSet<OrderStatus>();```

And you would create a static block and add the valid order statuses:
```
static {
        VALID_ORDER_STATUSES.add(new OrderStatus("01", "Order Placed"));
        VALID_ORDER_STATUSES.add(new OrderStatus("02", "Order Processed"));
        VALID_ORDER_STATUSES.add(new OrderStatus("03", "Order Cancelled"));
        VALID_ORDER_STATUSES.add(new OrderStatus("04", "Order Failed"));
    }
```

Wouldn’t be great if we can combine into one-step? Well, we can do by using Double Brace Initialization. Let’s see how it is going to look like:
```
final static Set<OrderStatus> VALID_ORDER_STATUSES_WITH_DOUBLE_BRACE = new HashSet<OrderStatus>() {{
            add(new OrderStatus("01", "Order Placed"));
            add(new OrderStatus("02", "Order Processed"));
            add(new OrderStatus("03", "Order Cancelled"));
            add(new OrderStatus("04", "Order Failed"));

        }};
```
This code is totally valid and works in all the version of java. You may wonder what is going on here?
The first brace creates anonymous inner/sub class that extends HashSet and the second one declares instance initializer. The inner class doesn’t add new instance variables, but it just contains an initializer block. 
Let’s see how we can apply this trick while creating OrderStatus with default constructor, not using two params constructor. 

```
OrderStatus INVALID_ORDER_STATUS = new OrderStatus() {{
            setCode("XX");
            setDescription("Invalid");
        }};
```

You have to note that if you create a new object with the same order status code and description is not exactly equal to the one you created. 

Let’s say you are creating a new:

```
OrderStatus INVALID_ORDER_STATUS_2 = new OrderStatus() {{
            setCode("XX");
            setDescription("Invalid");
        }};
```

```
OrderStatus INVALID_ORDER_STATUS_3 = new OrderStatus();
INVALID_ORDER_STATUS_3.setCode("XX");
INVALID_ORDER_STATUS_3.setDescription("Invalid");
```

```INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_2) ``` and ``` INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_3) ``` will return false, because it has different class. 
Collection classes should be fine if you create objects like the one we created. 

``` VALID_ORDER_STATUSES_WITH_DOUBLE_BRACE.contains(new OrderStatus("01", "Order Placed")) ``` will return true.

You can use the same trick, if you want to call some methods just after creating an object like this:
```
Action action = new Action() {{
                step1();
                step2();
            }};
String result = action.result();
```
