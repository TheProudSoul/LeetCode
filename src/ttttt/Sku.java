package ttttt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : zhengyijing
 * Date    : 2021/3/10
 * Time    : 5:24 下午
 * ---------------------------------------
 * Desc    :
 */
public class Sku {
  private Long skuId;
  private String name;

  public Sku(Long skuId, String name) {
    this.skuId = skuId;
    this.name = name;
  }

  public Long getSkuId() {
    return skuId;
  }

  @Override
  public String toString() {
    return "Sku{" +
        "skuId=" + skuId +
        ", name='" + name + '\'' +
        '}';
  }

  public static void main(String[] args) {
    Sku test1 = new Sku(1L, "yi");
    Sku test2 = new Sku(2L, "er");
    Sku test3 = new Sku(3L, "san");
    List<Sku> skuList1 = new ArrayList<Sku>() {{
      add(test1);
      add(test2);
      add(test3);
    }};
    Set<Long> skuSet = skuList1.stream().map(Sku::getSkuId).collect(Collectors.toSet());

    Sku test4 = new Sku(1L, "si");
    Sku test5 = new Sku(2L, "wu");
    Sku test6 = new Sku(3L, "liu");
    List<Sku> skuList2 = new ArrayList<Sku>() {{
      add(test4);
      add(test5);
      add(test6);
    }};
    skuList2.removeIf(sku -> skuSet.contains(sku.getSkuId()));
    skuList1.addAll(skuList2);
    System.out.println(skuList1);
  }
}
