package designPattern.builder;

// 抽象建造者接⼝
interface Builder {
    void buildPart1(String part1);

    void buildPart2(String part2);

    Product getResult();
}