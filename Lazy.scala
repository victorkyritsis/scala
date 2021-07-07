class Service {
  def connect = println("Connected")
}

var service: Service = null;
lazy val serviceRef = service
service = new Service
serviceRef.connect


val data = Map(
  "firstName" -> "Joe",
  "lastName" -> "Black"
)
