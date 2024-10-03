# Exclude Interface From Proguard
-keep class org.eu.thedoc.zettelnotes.interfaces.** { *; }
-keepclassmembers class org.eu.thedoc.zettelnotes.interfaces.** {
    <fields>;
    <init>();
    <methods>;
}