package com.example.skywlk.lab3;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by skywlk on 27.11.2016..
 */

public class DataStorage {

    public static HashMap<Integer, Cat> listViewData = new HashMap<Integer, Cat>();

    public static void fillData(){
        for (int i=0; i<names.length; i++){
            final boolean available = (i%3 == 0);
            Cat newCat = new Cat(i+1, names[i], descriptions[i], owners[i], ages[i], available );
            listViewData.put(i, newCat);
        }
    }





    private static String[] names = {"HERB", "HERCULES", "HERMES", "HERMIONE", "HERO", "HERSHEY",
            "HESTIA", "HIAWATHA", "HICKORY", "HIDYHO", "HIGGINS", "HIGHJUMP", "HILARIA",
            "HILARY", "HILDA", "HILDEGARD", "HINI", "HINX", "HISS", "HOBBES", "HOBBIT",
            "HOBGOBLIN", "HOBIECAT", "HOBSON", "HOCUS POCUS", "HODGE", "HODORI", "HOG", "HOGAN" };

    private static String[] descriptions = {
            "The Bengal Cat's activity level is very high and they love to play, run and leap. They are great climbers and jumpers. They could at times be described as mischievous. Bengals are not a cat to be ignored. They sometimes demand a lot of attention but they will always keep you entertained with their antics.",
            "Birman Cats are affectionate, intelligent, playful cats, and are the happiest in family or multi-pet households. Males, in particular, are often very talkative. They are a placid cat and very loyal to their owners. Birmans are gentle and playful. ",
            "Bombay Cats They are an outgoing cat, friendly and playful. They are easily leash trained and like to retrieve. They are a very sociable cat and make a great addition to the family as they get on well with children and dogs.  They are very agile and athletic and their antics will keep you constantly amused. ",
            "British Shorthair Cats are placid, non demanding, tolerant, docile and respectful. They are not vocal cats and in fact are very quiet and can cope with being alone without fretting. They are not inclined to wander. They love children and get along extremely well with dogs. ",
            "The Burmese Cat is a very friendly inquisitive cat with an outgoing, loving nature. The Burmese is an upfront cat, not left out of where it is all happening. It's a participator - alert, curious, intelligent, interfering and gregarious: you cannot ignore it! Burmese are one of the most popular breeds. It has been said that the Burmese are more like dogs than cats in their behaviour. ",
            "The Burmilla Cat is an outgoing, friendly and sociable cat Burmillas are great with children. Combined with their low maintenance and wonderful disposition they make an ideal family pet. ",
            "Burmilla Long Hair  The longhair Burmilla is bright and fun loving, but more laid back than its shorthair relative in most cases. It is an ideal cat for single people or families, being quite happy to wait until you come home for attention. They are not a demanding cat, but still love to spend as much time with you as possible. Many of them are very good “fetch-it” cats too! ",
            "Cheetoh Cat attributes include a super affectionate nature and real love for their human companions, great deal of intelligence with the ability to learn quickly and a keen instinct to hunt. The Cheetoh Cat is also extremely intelligent, very curious and quite dog-like in their ways. Cheetoh's are a sweet natured lap cat that look wild but have a dependable docile nature and can be trusted around anyone, especially children. ",
            "Chinchilla Cat Chinchillas are generally very placid, quiet cats, happy to lie around the home being decorative. They are affectionate, enjoy attention and can become quite attached to their owners. ",
            "Cornish Rex Cat Once seen, never forgotten. The Cornish Rex cat is delightful, distinctively different, constantly charming and captivating.  Rexes need people, and given a choice will spend most of their time with humans. They like people and they also like to participate in their activities. Using its paws like hands, a Cornish Rex can pick up small objects, and some have even learned to turn door knobs and open doors More Information Cornish Rex Cat Breed",
            "Devon Rex Cats: The character of the Devon Rex is remarkable! Devon Rex are alert and active, and shows a lively interest in their surroundings. They love to be with their humans, and enjoy playing fetch or other games. They are also extremely agile cats with an inquisitive nature and will explore every corner of their homes. ",
            "Egyptian Mau The average Mau is quite clingy to his owners; some will take to only one member of the family, while others will take over the entire household. Whichever way it goes, once the Mau has bonded, he is your lover for life and will actively participate in anything that you are doing (whether you want him there or not) ",
            "Exotic Shorthairs The personality of the Exotic cat is like that of the Persian, outgoing, placid, easy to handle and beautiful to look at. This combined with a sense of immense curiosity about what goes on about them makes them the ideal companion. They are most happy when they are with people and love playing with children or just sitting on a lap or on the arm of your chair. ",
            "Highlander Cat The Highlander cat will steal your heart with their fun loving nature and crazy antics. This breed is extremely affectionate, gentle and also very playful. The Highlander cat loves to be the centre of attention. They are a high energy cat with an inquisitive nature. They love to chase and play. ",
            "Himalayan Cats Along with their striking appearance, Himalayans have a wonderfully outgoing and engaging personality being extremely affectionate, playful and endearing.  Many Himalayan fanciers would say they are the most outgoing of all Persian cats. ",
            "Maine Coon Cats are a loyal gentle cat. They are often known as the Gentle Giant of the cat world. They are a vocal breed with a variety of meows, chirps and trills. They are very sociable and get on well with children and other pets. They love to be part of the family and will join in most family activities. ",
            "The Norwegian Forest Cat enjoys being with people and other pets and is excellent with children. They are very patient animals and are not stressed easily. They are very intelligent and have a natural curiosity. They like to be up high to survey their kingdom. A climbing tree is perfect and they will spend endless amounts of energy going up and down doing all they can to impress you with their athletic abilities.",
            "Ocicat The Ocicat personality and temperament are predictable and loving - they make a wonderful addition to any household - they generally adapt readily to most situations, including children and other pets.  They are a beautiful, wild looking cat with the best domestic cat personality, very active and ready to play, but willing to purr on your lap too. ",
            "Oriental Cats Orientals eagerly greet you at the door and tell you all about their day. If you’re late, they will scold you and tell you how worried they were that you didn't call. Curiosity and intelligence combined, providing Orientals a means of finding anything and everything. They have been known to open a drawer, or empty your purse to discover their favourite toy. Give Orientals the attention and affection they so desperately need, and they will do anything to please you. Ignore them, and they will droop with despair. ",
            "Persian Cats are usually a quiet and gentle cat. They are calm and undemanding and can be very affectionate. They are very placid and unlikely to scratch anyone. Because of the Persian's serene nature they usually get on well with other pets and are great with children that are not too boisterous. They love to be stroked and patted and lap up any attention you give them. ",
            "Ragdoll Cats are extremely docile and love to be held and cuddled. They are usually relaxed in new surroundings and get on well with dogs and cats.  Ragdolls are very affectionate and gentle making them an ideal pet for children.They have a quiet voice and are playful without being noisy or destructive. Ragdolls are a very laid back cat and become devoted to their owners. ",
            "Russian Blue The Russian Blue has a quiet sometimes shy although very affectionate personality. They are very soft spoken and you rarely hear them speak. They are very well suited to indoor life.The Russian Blue's quiet tranquil personality may best suit a family with the same characteristics. They are very loyal and become devoted to their owners.The Russian Blue is an intelligent cat, playful and sweet. They like to join in family activities. ",
            "Scottish Folds. Scottish Folds are a very friendly and docile cat. Their large round eyes and folded ears, coupled with expressive looks, intelligence and inquisitive nature make them a wonderful extension to the family home. Folds are not very vocal. Scottish Folds have very tiny 'meows'. The breed is very good with children, and can adapt to almost any situation. Scottish Folds also make friends readily with other cats. ",
            "Selkirk Rex They are curious, tolerant, extremely sociable cats that enjoy spending time with their preferred persons. People-oriented without being clingy, Selkirks have a generous measure of love and loyalty for their human companions. Selkirks fit in well with other family members including children, and usually get along well with other companion animals ",
            "Siamese Cats are a very intelligent, lively, entertaining cat. They can be very demanding and become totally involved in their owner's life. Siamese do not like to be ignored and always have to be the centre of attention. They usually regard themselves as people rather than cats. You will never be bored if you own a Siamese cat. ",
            "Siberian Cats Personality Plus. The Siberian has a very dog like temperament and are very affectionate. They come out to great the visitors in the house and are not shy. They are very intelligent and very quick learners. They also have a triple purr and unlike other breeds have a chirping sound they use when they come to greet you. When they are around water they appear to be fascinated with it and will drop toys into it and play in sinks with water left in. The Siberian makes the ideal lap cat and will live quite happily indoors with you. ",
            "Singapura Cats Singapura cats are mischievous and inquisitive, meaning that they will investigate anything thoroughly. They are very quick witted, able to adapt and learn, intelligent, lightning fast and genuinely tough and hardy. They get on well with children and other pets.They have enchanting personalities, always wanting to please and entertain you. Soft sweet little voices that question you and answer you back. They are truly people pleasers. ",
            "Somali Cats have bright, bubbly, energetic and loving personalities. They are very intelligent and active cats, who demonstrate a real devotion to their staff. Somali cats are intensely affectionate to their people, and are usually extroverted and enjoy visitors also. These cats make their presence felt - they share their special joie de vivre with the humans in their lives. They often like to sit on your shoulder to supervise what you are doing, will help with the housework - they are great at making the beds! ",
            "Sphynx Cats  Sphynx are very active and love to the centre of attention, they are not suited to people wanting a quiet docile cat. Sphynx have a friendly disposition and are very sociable with other people and pets. Sphynx are very intelligent and can be taught to walk on a lead and respond to voice commands. They are often described as the most intelligent and affectionate of all cat breeds." };

    private static String[] owners = {"Aali", "Aaliyah", "Abbas", "Abdukrahman", "Abdulkareem", "Abdullah", "Abdulrahman", "Abednego",
            "Abia", "Abla", "Adil", "Adila", "Adli", "Adnan", "Afaf", "Ahmad", "Ahmed",
            "Aisha", "Aizza", "Akeem", "Akon", "Akram", "Ala", "Aladdin", "Alawi", "Alem", "Ali", "Alia", "Alim"};

    private static int[] ages = {6, 7, 5, 3, 15, 6, 8, 8, 2, 4,
            7, 1, 2, 2, 4, 6, 5, 7, 4, 13,
            3, 5, 6, 7, 8, 9, 1, 10, 3};

}
