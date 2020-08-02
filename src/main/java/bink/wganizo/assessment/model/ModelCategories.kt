 class ModelCategories{
        lateinit var id:String
        lateinit var name:String
        lateinit var descr:String
        lateinit var thumbnail:String

        constructor(id: String,name:String,descr:String,thumbnail:String) {
                this.id = id
                this.name = name
                this.descr = descr
                this.thumbnail = thumbnail;
        }

        constructor()
}