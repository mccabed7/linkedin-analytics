import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val spark = SparkSession.builder()
      .appName("Scala Spark Test")
      .master("local[*]")  // ✅ Ensures local execution
      .config("spark.driver.host", "127.0.0.1")  // ✅ Forces correct binding
      .config("spark.driver.bindAddress", "127.0.0.1")  // ✅ Prevents incorrect host resolution
      .getOrCreate()

    val data = Seq(("Alice", 25), ("Bob", 28), ("Charlie", 30))
    val df = spark.createDataFrame(data).toDF("Name", "Age")

    df.show()

    spark.stop()
  }
}