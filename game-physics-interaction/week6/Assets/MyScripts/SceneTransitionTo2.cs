using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneTransitionTo2 : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if ( Input.GetKeyDown(KeyCode.F2))
        {
            SceneManager.LoadScene(1, LoadSceneMode.Single);
        }
    }
}
