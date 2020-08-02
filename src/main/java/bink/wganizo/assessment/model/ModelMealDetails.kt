 class ModelMealDetails{
        lateinit var name:String
        lateinit var instructions:String
        lateinit var thumbnails:String

        constructor(name:String,instructions:String,strMealThumb:String) {
                this.name = name
                this.instructions = instructions
                this.thumbnails = strMealThumb
        }

        constructor()
}